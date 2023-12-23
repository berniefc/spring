package com.spring;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fc
 * @date 2023/12/22 15:21
 */
public class PropertyValues {

    private List<PropertyValue> propertyValues = new ArrayList<>();
    ;

    public void addPropertyValue(PropertyValue propertyValue) {
        this.propertyValues.add(propertyValue);
    }

    public PropertyValue[] getPropertyValues() {
        return propertyValues.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValues(String propertyName) {
        for (PropertyValue propertyValue : propertyValues) {
            if (propertyValue.getName().equals(propertyName)) {
                return propertyValue;
            }
        }
        return null;
    }

    public void setPropertyValues(List<PropertyValue> propertyValues) {
        this.propertyValues = propertyValues;
    }
}
