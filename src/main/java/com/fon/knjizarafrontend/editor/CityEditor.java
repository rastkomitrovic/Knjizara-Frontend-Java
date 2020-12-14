package com.fon.knjizarafrontend.editor;

import com.fon.knjizarafrontend.dto.CityDTO;
import com.fon.knjizarafrontend.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class CityEditor extends PropertyEditorSupport {

    @Autowired
    private CityService cityService;

    @Override
    public void setAsText(String s) throws IllegalArgumentException {
        Long cityId=Long.parseLong(s);
        CityDTO cityDTO=cityService.findCityByCityId(cityId).getBody();
        this.setValue(cityDTO);
    }
}
