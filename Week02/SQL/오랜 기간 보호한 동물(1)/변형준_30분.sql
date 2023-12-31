SELECT NAME, DATETIME
FROM (
    SELECT NAME, DATETIME, ROWNUM AS RN
    FROM (
        SELECT I.NAME, I.DATETIME
        FROM ANIMAL_INS I
        WHERE NOT EXISTS(
            SELECT O.NAME, O.DATETIME
            FROM ANIMAL_OUTS O
            WHERE O.ANIMAL_ID = I.ANIMAL_ID
        )
        ORDER BY I.DATETIME
    )
) C
WHERE C.RN < 4;
