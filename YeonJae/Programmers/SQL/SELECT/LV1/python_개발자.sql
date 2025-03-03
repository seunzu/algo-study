SELECT ID, EMAIL,FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE SKILL_1 = "Python" or  SKILL_2 = "Python" or  SKILL_3 = "Python" 
ORDER BY ID


--  SELECT 
--      id, email, first_name, last_name
--  FROM
--      developer_infos
--  WHERE 
--      'Python' IN (skill_1, skill_2, skill_3)
--  ORDER BY
--      1;