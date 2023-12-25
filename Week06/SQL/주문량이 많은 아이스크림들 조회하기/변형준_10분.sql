SELECT h.flavor
FROM first_half h, july j
WHERE h.flavor = j.flavor
GROUP BY h.flavor
ORDER BY sum(h.total_order + j.total_order) desc
FETCH FIRST 3 ROW ONLY;
