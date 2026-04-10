##중성화된 동물은 O 중성화되지 않은 동물 X
SELECT ANIMAL_ID,
       NAME,
       CASE 
        WHEN SEX_UPON_INTAKE LIKE 'Neutered%' 
            or SEX_UPON_INTAKE LIKE 'Spayed%' THEN 'O'
        ELSE 'X'
       END AS 중성화 
FROM ANIMAL_INS
ORDER BY ANIMAL_ID;