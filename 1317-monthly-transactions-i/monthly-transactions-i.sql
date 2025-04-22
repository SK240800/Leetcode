# Write your MySQL query statement below
-- with tc as (
--     select concat(year(trans_date),'-',LPAD(month(trans_date),2,0)) as month,country,coalesce(count(amount),0)as trans_count
--     from Transactions
--     group by month,country
--     ),
--     ap as(
--         select concat(year(trans_date),'-',LPAD(month(trans_date),2,0)) as month,country,coalesce(count(amount),0) as approved_count,coalesce(sum(amount),0) as approved_total_amount
--         from Transactions
--        where state='approved' 
--         group by month,country
--     ),
--     tta as(
--         select concat(year(trans_date),'-',LPAD(month(trans_date),2,0)) as month,country,coalesce(sum(amount),0) as trans_total_amount
--         from Transactions
--         group by month,country
--     )
-- SELECT tc.month,tc.country,tc.trans_count,ap.approved_count,tta.trans_total_amount,ap.approved_total_amount
-- FROM tc
-- LEFT JOIN ap 
--     ON tc.month = ap.month AND tc.country = ap.country
-- LEFT JOIN tta 
--     ON tc.month = tta.month AND tc.country = tta.country;
SELECT 
    CONCAT(YEAR(trans_date), '-', LPAD(MONTH(trans_date), 2, '0')) AS month,
    country,
    COUNT(*) AS trans_count,
    SUM(state = 'approved') AS approved_count,
    SUM(amount) AS trans_total_amount,
    SUM(CASE WHEN state = 'approved' THEN amount ELSE 0 END) AS approved_total_amount
FROM Transactions
GROUP BY month, country
ORDER BY month, country;