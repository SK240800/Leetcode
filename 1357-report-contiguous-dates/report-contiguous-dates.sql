SELECT stats AS period_state, MIN(date) AS start_date, MAX(date) AS end_date
FROM (SELECT 
        date, 
        RANK() OVER (ORDER BY date) AS overall_ranking, 
        stats, 
        rk, 
        (RANK() OVER (ORDER BY date) - rk) AS inv
    FROM ((select fail_date as date,'failed' AS stats, RANK() OVER (ORDER BY fail_date) AS rk 
from Failed
where fail_date between '2019-01-01' and '2019-12-31'

union 

select success_date as date,'succeeded' AS stats, RANK() OVER (ORDER BY success_date) AS rk
from Succeeded
where success_date between '2019-01-01' and '2019-12-31')
order by date
    ) c)t
GROUP BY inv, stats
ORDER BY start_date