package com.logikas.hipokrates.patient.shared.place;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;

/**
 *
 * @author Cristian Rinaldi
 * Logikas.
 */
@WithTokenizers({DashboardPatientPlace.Tokenizer.class})
public interface PatientPlaceHistoryMapper extends PlaceHistoryMapper{
    
}
