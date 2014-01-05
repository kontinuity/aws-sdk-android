package com.j256.ormlite.field.types;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.j256.ormlite.field.FieldType;
import com.j256.ormlite.field.SqlType;
import com.j256.ormlite.support.DatabaseResults;

import java.sql.SQLException;
import java.util.UUID;

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
	public Object sqlArgToJava(FieldType fieldType, Object sqlArg, int columnPos) throws SQLException {
        return new Gson().fromJson(sqlArg.toString(), fieldType.getType());
	}

	@Override
	public Object javaToSqlArg(FieldType fieldType, Object obj) {
        return new Gson().toJson(obj);
	}

	@Override
	public boolean isValidGeneratedType() {
		return true;
	}

	@Override
	public boolean isSelfGeneratedId() {
		return true;
	}

	@Override
	public Object generateId() {
		return UUID.randomUUID();
	}

	@Override
	public int getDefaultWidth() {
		return DEFAULT_WIDTH;
	}
}
