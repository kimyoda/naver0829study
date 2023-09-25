select buseo, count(*) count, max(score) maxscore, min(score) minscore, avg(score) avgscore
from sawon group by buseo;