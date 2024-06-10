CREATE SEQUENCE SQ_CHUVA
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;


CREATE TABLE tbl_sensor_chuva (
    ID INTEGER DEFAULT SQ_CHUVA.NEXTVAL NOT NULL,
    precipitacao INTEGER NOT NULL,
    data INTEGER NOT NULL,
    cto INTEGER

);