SELECT ANIMAL_ID, NAME
FROM ANIMAL_INS I
WHERE DATETIME > (SELECT DATETIME 
                  FROM ANIMAL_OUTS
                 WHERE ANIMAL_ID = I.ANIMAL_ID)
ORDER BY DATETIME;
