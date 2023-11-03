package com.ikkat.los.enumeration;

public enum MessageEnum {
	CREATE("BERHASIL MEMBUAT DATA"),
	DELETE("BERHASIL MENGHAPUS DATA"),
	UPDATE("BERHASIL MEMPERBARUI DATA"),
	ID_EXIST("ID SUDAH DIGUNAKAN"),
	ID_NOT_EXIST("ID TIDAK DIKENAL");
	private String value;
	MessageEnum(String value) {
        this.value = value;
    }
    public String value() {
        return value;
    }
}
