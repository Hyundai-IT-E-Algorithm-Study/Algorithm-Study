-- SELECT to_char(datetime,'HH24') as hour, count(*) as count
-- FROM animal_outs
-- GROUP BY to_char(datetime,'HH24')
-- HAVING to_char(datetime,'HH24') >=0 AND to_char(datetime,'HH24') <=23
-- ORDER by 1;

SELECT t1.hour, nvl(t2.count,0)
FROM (SELECT level-1 as hour
      FROM dual
      CONNECT BY level<=24) t1 
      LEFT JOIN (SELECT to_char(datetime,'HH24') as hour, count(*) as count
                  FROM animal_outs
                  GROUP BY to_char(datetime,'HH24')) t2
ON t1.hour = t2.hour
ORDER BY 1
