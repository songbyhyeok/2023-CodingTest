SELECT ANIMAL_ID, NAME, 
    CASE 
        WHEN SUBSTRING_INDEX(SEX_UPON_INTAKE, ' ', 1) = 
        'Neutered'
        OR SUBSTRING_INDEX(SEX_UPON_INTAKE, ' ', 1) = 
        'Spayed' 
        THEN 'O'
        ELSE 'X'
    END AS '중성화'
FROM ANIMAL_INS

