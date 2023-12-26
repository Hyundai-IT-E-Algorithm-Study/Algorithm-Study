SELECT flavor
FROM(SELECT rownum, t1.flavor, t1.total+t2.total as total
FROM (SELECT flavor, sum(total_order) as total
      FROM july
      GROUP BY flavor) t1 INNER JOIN (SELECT flavor, sum(total_order) as total                                       
                                      FROM first_half
                                      GROUP BY flavor) t2
ON t1.flavor=t2.flavor 
order by total desc) 
WHERE rownum<4
