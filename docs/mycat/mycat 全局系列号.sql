use intelligence_management_01;

DROP TABLE IF EXISTS MYCAT_SEQUENCE;

CREATE TABLE MYCAT_SEQUENCE (
NAME VARCHAR (50) NOT NULL,
current_value INT NOT NULL,
increment INT NOT NULL DEFAULT 100,
PRIMARY KEY (NAME)
) ENGINE = INNODB;


INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('GLOBAL', 0, 100);


-- 授权 给 root  所有sql 权限
grant all privileges on *.* to root@"%" identified by ".";

flush privileges;


-- 获取当前sequence的值 (返回当前值,增量)
DROP FUNCTION IF EXISTS `mycat_seq_currval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `mycat_seq_currval`(seq_name VARCHAR(50)) RETURNS varchar(64) CHARSET latin1
DETERMINISTIC
BEGIN
DECLARE retval VARCHAR(64);
SET retval="-999999999,null";
SELECT concat(CAST(current_value AS CHAR),",",CAST(increment AS CHAR) ) INTO retval FROM MYCAT_SEQUENCE WHERE name = seq_name;
RETURN retval ;
END
;;
DELIMITER ;


-- 设置sequence值
DROP FUNCTION IF EXISTS `mycat_seq_nextval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `mycat_seq_nextval`(seq_name VARCHAR(50)) RETURNS varchar(64)
 CHARSET latin1
    DETERMINISTIC
BEGIN 
         UPDATE MYCAT_SEQUENCE  
                 SET current_value = current_value + increment 
                  WHERE name = seq_name;  
         RETURN mycat_seq_currval(seq_name);  
END
;;
DELIMITER ;


-- 获取下一个sequence值
DROP FUNCTION IF EXISTS `mycat_seq_setval`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `mycat_seq_setval`(seq_name VARCHAR(50), value INTEGER) 
RETURNS varchar(64) CHARSET latin1
    DETERMINISTIC
BEGIN 
         UPDATE MYCAT_SEQUENCE  
                   SET current_value = value  
                   WHERE name = seq_name;  
         RETURN mycat_seq_currval(seq_name);  
END
;;
DELIMITER ;




INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_AREA', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_LOG', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_CONFIG', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_USER', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_USER_DEPARTMENT', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_USER_PERMISSION', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_USER_ROLE', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_USER_ROLE_PERMISSION', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_USER_USER_ROLE', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SCHEDULE_JOB', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SCHEDULE_JOB_LOG', 0, 1);




INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('INTELLIGENCE_BUSINESS_TYPE', 0, 1);


INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('INTELLIGENCE_IMPORT', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('INTELLIGENCE_SHARE_PERMISSION', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SEARCH_LOG', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('COMMON_TOOL', 0, 1);


INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('LOGISTICS_COMPANY', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('LOGISTICS_USER', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('LOGISTICS_RECORD', 0, 1);



INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('EXPRESS_COMPANY', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('EXPRESS_USER', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('EXPRESS_RECORD', 0, 1);


INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('INTELLIGENCE', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('INTELLIGENCE_OFFICER', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_WECHAT', 0, 1);


INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_SEARCHWARNING_CONFIG', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('SYS_SEARCHWARNING_LOG', 0, 1);


INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('IMPORTANT_PERSON', 0, 1);


INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('ACTIVITY_DETAIL', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('WARNING_DISPOSTION', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('DISPOSAL_MEASURES', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('DISPOSITION_RESULT', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_CHECKIN_CHECKOUT_RECORD', 0, 1);
-- INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_CHECKIN_CHECKOUT_USER', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_OUTPATIENT_RECORD', 0, 1);
-- INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_OUTPATIENT_USER', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_EXAMINATION_RECORD', 0, 1);
-- INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_EXAMINATION_USER', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('HOSPITAL_UNIT_INFORMATION', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_CHECKIN_CHECKOUT_RECORD_TRANSFER', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_OUTPATIENT_RECORD_TRANSFER', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_INSURANCE_CARD_RECORD', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_INSURANCE_CARD_RECORD_TRANSFER', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_NEWBORN_RECORD', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_NEWBORN_RECORD_TRANSFER', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_PATIENT_RECORD', 0, 1);
INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('MEDICAL_PATIENT_RECORD_TRANSFER', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('CONTROL_APPLY_APPLICATION', 0, 1);

INSERT INTO MYCAT_SEQUENCE(name,current_value,increment) VALUES ('STATIC_FILE_CLASS', 0, 1);