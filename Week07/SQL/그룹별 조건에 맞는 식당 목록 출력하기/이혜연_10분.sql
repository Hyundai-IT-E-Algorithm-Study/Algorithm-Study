SELECT m.member_name, r.review_text, to_char(r.review_date, 'YYYY-MM-DD') as REVIEW_DATE
FROM member_profile m INNER JOIN rest_review r
ON m.member_id = r.member_id
WHERE m.member_id IN (SELECT member_id
                     FROM rest_review 
                     GROUP BY member_id
                     HAVING count(review_id) = (SELECT max(count(*))
                                                FROM rest_review
                                                GROUP BY member_id
                                               ) 
                     )
ORDER BY REVIEW_DATE, r.review_text
