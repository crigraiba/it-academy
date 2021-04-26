USE dbsegundo;

SELECT
	ENAME,
	(
		CASE
			WHEN COMM > 0 THEN 'YES'
			WHEN COMM = 0 THEN 'NO'
			WHEN COMM IS NULL THEN 'UNKNOWN'
		END
	) AS COMM,
	IFNULL(SAL+COMM, SAL) AS SALARIO_TOTAL,
	IFNULL(SAL+COMM, SAL)*1.06 AS '6%',
	IFNULL(SAL+COMM, SAL)*1.07 AS '7%'
FROM
	empleados
ORDER BY
	ENAME;