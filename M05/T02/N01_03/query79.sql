USE dbsegundo;

SELECT
	e1.*
FROM
	empleados e1
JOIN
	(
		SELECT
			DISTINCT SAL
		FROM
			empleados
		GROUP BY
			SAL
		ORDER BY
			SAL DESC			
		LIMIT
			2
	) e2
ON
	e1.SAL = e2.SAL
ORDER BY
	e1.SAL DESC;