SELECT CAR_ID
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
    WHERE '10' <= MONTH(START_DATE)
) AND CAR_TYPE = '세단' 
ORDER BY CAR_ID DESC