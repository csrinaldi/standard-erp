package com.logikas.kratools.annextract.client;

import com.logikas.kratools.annextract.domain.Person;
import com.logikas.kratools.annextract.shared.AllowedWrappers;
import com.logikas.kratools.annextract.shared.AnnotationExtractor;
import com.logikas.kratools.annextract.shared.DefaultsToNull;
import com.logikas.kratools.annextract.shared.ExtractorFor;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;

import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class Annextract implements EntryPoint {
  
  @AllowedWrappers
  static interface ValidationAnnotationExtractor extends AnnotationExtractor {
  }
	
  @AllowedWrappers
	//@DefaultsToNull
	@ExtractorFor(Person.class)
	static interface PersonAnnotationExtractor extends ValidationAnnotationExtractor {
		
		@Property("name")
		Size nameSize();
		
		@Property("surname")
		Pattern.List surname();
		
		@DefaultsToNull
		@Property("surname")
		Null surnameNull();
		
		@Property("surname")
		Size.List surnameSizeList();
	}

	@Override
	public void onModuleLoad() {
		
		final PersonAnnotationExtractor extractor = GWT.create(PersonAnnotationExtractor.class);
		
		final int nameSizeMessage = extractor.nameSize().min();
		final String surnamePattern = extractor.surname().value()[0].regexp();
		
		Window.alert("nameSizeMin = " + nameSizeMessage + "surnamePattern = " + surnamePattern + "surnameNull = " + extractor.surnameNull());		
	}
}
