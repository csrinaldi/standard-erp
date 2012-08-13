package com.logikas.kratos.core.locator;

import com.logikas.kratos.core.repository.EntityFinder;

import com.google.web.bindery.requestfactory.shared.Locator;

public class FinderEntityLocator<T, I, F extends EntityFinder<T, I>> extends Locator<T, I> {
  
  private EntityFinder<T, I> finder;
  
  public void setFinder(EntityFinder<T, I> finder) {
    this.finder = finder;
  }
  
  @Override
  public T create(Class<? extends T> clazz) {
   
    return null;
  }
  
  @Override
  public T find(Class<? extends T> clazz, I id) {
    return finder.find(id);
  }
    
}
