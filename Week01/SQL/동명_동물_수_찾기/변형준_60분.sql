SELECT name, count(name) AS count
FROM animal_ins
WHERE name IS NOT NULL
GROUP BY name
HAVING count(name) > 1
ORDER BY name;
