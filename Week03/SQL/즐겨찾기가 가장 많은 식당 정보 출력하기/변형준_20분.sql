SELECT food_type, rest_id, rest_name, favorites
FROM (
  SELECT food_type, rest_id, rest_name, favorites
    , RANK() OVER(PARTITION BY food_type ORDER BY favorites DESC) AS rank
  FROM rest_info
) r
WHERE rank = 1
ORDER BY food_type desc;
