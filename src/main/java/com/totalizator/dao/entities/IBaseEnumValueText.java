package com.totalizator.dao.entities;

/**
 * Created by kasyanov on 6/17/2016.
 */


public interface IBaseEnumValueText {
	int getValue();

	String getDescription();

	class BaseEnumValueTextHelpher {
		public static <T extends Enum<?> & IBaseEnumValueText> T getFromValue(int value, Class<T> type) {
			T[] values = type.getEnumConstants();
			for (T val : values)
				if (val.getValue() == value)
					return val;
			return null;
		}
	}
}

