package com.j256.ormlite.field.types;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.field.DatabaseFieldConfig;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;

import java.sql.SQLException;
import java.util.*;

/**
 * Type that persists a {@link java.util.UUID} object.
 *
 * @author graywatson
 */
public class JsonType extends BaseDataType {

	public static int DEFAULT_WIDTH = 2147483647;

	private static final JsonType singleton = new JsonType();

	public static JsonType getSingleton() {
		return singleton;
	}

	private JsonType() {
		super(SqlType.STRING, new Class<?>[] {});
	}

	/**
	 * Here for others to subclass.
	 */
	protected JsonType(SqlType sqlType, Class<?>[] classes) {
		super(sqlType, classes);
	}

	@Override
	public Object parseDefaultString(FieldType fieldType, String defaultStr) throws SQLException {
        return defaultStr;
	}

	@Override
	public Object resultToSqlArg(FieldType fieldType, DatabaseResults results, int columnPos) throws SQLException {
		return results.getString(columnPos);
	}

	@Override
    @SuppressWarnings("unchecked")
	public Object sqlArgToJava(FieldType fieldType, Object sqlArg, int columnPos) throws SQLException {

        String json = (String) sqlArg;
        if (json == null || json.length() == 0) {
            return Collections.emptyList();
        }

        DatabaseFieldConfig configObj = fieldType.getFieldConfig();

        if (configObj.getItemClass() == null
            || configObj.getItemClass().equals(Void.class)
            || configObj.getContainerClass().equals(Void.class)) {
            return new Gson().fromJson(json, fieldType.getType());
        } else {
            Class containerClass = configObj.getContainerClass();

            JsonParser jsonParser = new JsonParser();
            JsonArray elements = jsonParser.parse(json).getAsJsonArray();
            Gson gson = new Gson();
            try {
                List container = (List) containerClass.newInstance();
                for (JsonElement je : elements) {
                    container.add(gson.fromJson(je, configObj.getItemClass()));
                }
                return container;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
	}

    @Override
	public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return new Gson().toJson(obj);
	}

	@Override
	public int getDefaultWidth() {
		return DEFAULT_WIDTH;
	}
}
