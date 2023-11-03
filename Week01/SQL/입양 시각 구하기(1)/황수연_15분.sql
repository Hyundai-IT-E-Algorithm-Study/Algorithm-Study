SELECT to_number(to_char(datetime,'HH24')) as hour, count(datetime) as count
from animal_outs
group by to_char(datetime,'HH24') 
having to_char(datetime,'HH24') >= 9 and to_char(datetime,'HH24') <= 19
order by to_char(datetime,'HH24');
