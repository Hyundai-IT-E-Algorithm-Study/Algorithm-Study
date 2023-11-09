select to_number(to_char(datetime, 'HH24')) as HOUR, count(*)
from animal_outs
group by to_number(to_char(datetime, 'HH24'))
having to_number(to_char(datetime, 'HH24')) between 9 and 19
order by HOUR;
