CREATE TABLE jar_index (
    primaryKey int IDENTITY(1,1) PRIMARY KEY,
    jar_name varchar(255) NOT NULL,
	jar_hash char(32) NOT NULL,
	artifact varchar(1024) NOT NULL
);

CREATE INDEX idx_jar_hash
ON jar_index (jar_hash);

CREATE TABLE class_index (
    primaryKey int IDENTITY(1,1) PRIMARY KEY,
    class_name varchar(255) NOT NULL,
    class_hash char(32) NOT NULL
);

CREATE INDEX idx_class_name
ON class_index (class_name);

CREATE INDEX idx_class_hash
ON class_index (class_hash);

CREATE TABLE jar_class_mapping (
    jar_key int NOT NULL FOREIGN KEY REFERENCES jar_index(primaryKey),
    class_key int NOT NULL FOREIGN KEY REFERENCES class_index(primaryKey)
);

CREATE TABLE method_body(
    primaryKey int,
	body varchar(max) NOT NULL
);

CREATE TABLE method_index (
    primaryKey int IDENTITY(1,1) PRIMARY KEY,
    bodyhash char(32) NOT NULL,
    body_signature_hash char(32) NOT NULL,
    methodsignature varchar(500) NOT NULL,
	pluginid int NOT NULL,
	size int NOT NULL
);

CREATE INDEX idx_bodyhash
ON method_index (bodyhash);

CREATE TABLE class_method_mapping (
    class_key int NOT NULL FOREIGN KEY REFERENCES class_index(primaryKey),
    method_key int NOT NULL FOREIGN KEY REFERENCES method_index(primaryKey),
);