SELECT flavor
FROM (
    SELECT h.flavor,
        SUM(h.total_order) AS sum_h,
        SUM(j.total_order) AS sum_j
    FROM first_half h
    JOIN july j ON h.flavor = j.flavor
    GROUP BY h.flavor
    ORDER BY SUM(h.total_order) + SUM(j.total_order) DESC
)
WHERE rownum <= 3;
