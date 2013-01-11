package com.logikas.common.auditory.guice;


import com.google.inject.AbstractModule;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;
import com.google.inject.util.Types;
import com.logikas.common.auditory.Auditory;

import java.lang.reflect.ParameterizedType;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Andrés Testi (atesti@quiencotiza.com)
 * @since 04/01/2013
 */
public class AuditoryModule<S> extends AbstractModule {

  private final Class<S> subjectType;

  private Map<Class<?>, AuditoryFieldConverter<Date, ?>> timeConverters = null;
  private Map<Class<?>, AuditoryFieldConverter<S, ?>> subjectConverters = null;

  public AuditoryModule(Class<S> subjectType) {
    this.subjectType = subjectType;
  }

  @SuppressWarnings("unchecked")
  protected AuditoryModule() {

    @SuppressWarnings("rawtypes")
    final TypeLiteral<? extends AuditoryModule> literal = TypeLiteral.get(getClass());

    final TypeLiteral<?> genericLiteral = literal.getSupertype(AuditoryModule.class);
    final ParameterizedType generic = (ParameterizedType) genericLiteral.getType();
    subjectType = (Class<S>) generic.getActualTypeArguments()[0];
  }

  static class CalendarConverter implements AuditoryFieldConverter<Date, Calendar> {

    public Calendar to(Date date) {
      final Calendar cal = Calendar.getInstance();
      cal.setTime(date);
      return cal;
    }
    
    @Override
    public Date from(Calendar to) {
      return to.getTime();
    }
  }

  static class TimestampConverter implements AuditoryFieldConverter<Date, Long> {

    public Long to(Date date) {
      return date.getTime();
    }
    
    @Override
    public Date from(Long to) {     
      return new Date(to);
    }
  }

  @Override
  protected final void configure() {

    if (AuditoryEntityListener.auditor != null) {
      addError("Too many %s installed", AuditoryModule.class.getSimpleName());
      return;
    }

    @SuppressWarnings("unchecked")
    final TypeLiteral<EntityAuditor<?>> type =
        (TypeLiteral<EntityAuditor<?>>) TypeLiteral.get(Types.newParameterizedType(
            EntityAuditor.class, subjectType));

    final Key<EntityAuditor<?>> key = Key.get(type);

    AuditoryEntityListener.auditor = getProvider(key);

    timeConverters = new HashMap<Class<?>, AuditoryFieldConverter<Date, ?>>();

    bindTimeConverter(Calendar.class, new CalendarConverter());

    final TimestampConverter tsc = new TimestampConverter();

    bindTimeConverter(Long.class, tsc);
    bindTimeConverter(long.class, tsc);

    subjectConverters = new HashMap<Class<?>, AuditoryFieldConverter<S, ?>>();

    configureAudit();

    bind(new TypeLiteral<Map<Class<?>, AuditoryFieldConverter<Date, ?>>>() {
    }).annotatedWith(Auditory.class).toInstance(Collections.unmodifiableMap(timeConverters));

    @SuppressWarnings({"rawtypes", "unchecked"})
    final TypeLiteral<Map<Class<?>, AuditoryFieldConverter<S, ?>>> userConvertersType =
        (TypeLiteral) TypeLiteral.get(Types.newParameterizedType(Map.class, Types
            .newParameterizedType(Class.class, Types.subtypeOf(Object.class)), Types
            .newParameterizedType(AuditoryFieldConverter.class, subjectType, Types
                .subtypeOf(Object.class))));

    bind(userConvertersType).annotatedWith(Auditory.class).toInstance(
        Collections.unmodifiableMap(subjectConverters));

    timeConverters = null;
    subjectConverters = null;
  }

  protected void configureAudit() {
  }

  private <C, T> void bindConverter(Map<Class<?>, AuditoryFieldConverter<C, ?>> map,
      Class<C> fromType, Class<T> toType, AuditoryFieldConverter<C, T> converter) {
    if (map.containsKey(toType)) {
      addError("Already bound converter from type %s to type %s", fromType.getName(), toType
          .getName());
    } else {
      map.put(toType, converter);
    }
  }

  protected <T> void bindTimeConverter(Class<T> timeType, AuditoryFieldConverter<Date, T> converter) {
    bindConverter(timeConverters, Date.class, timeType, converter);
  }

  protected <T> void bindSujectConverter(Class<T> subjectType,
      AuditoryFieldConverter<S, T> converter) {
    bindConverter(subjectConverters, this.subjectType, subjectType, converter);
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof AuditoryModule;
  }

  @Override
  public int hashCode() {
    return AuditoryModule.class.hashCode();
  }
}
