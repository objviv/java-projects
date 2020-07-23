package com.intuit.martech.MarketPlace;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;

public class CalendarSerializer extends JsonSerializer<Calendar> implements com.google.gson.JsonSerializer<Calendar>{

    private SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");

    @Override
    public void serialize(Calendar calendar, JsonGenerator jsonGenerator,
                          SerializerProvider serializerProvider) throws IOException {

        String dateAsString = formatter.format(calendar.getTime());
        jsonGenerator.writeString(dateAsString);

    }

	@Override
	public JsonElement serialize(Calendar src, Type typeOfSrc, JsonSerializationContext context) {
		 
		String dateAsString = formatter.format(src.getTime());
		return new JsonPrimitive(dateAsString);
	}
}