USE dbsegundo;

SELECT
	*
FROM
	empleados
HAVING
	JOB IN(
		SELECT
			DISTINCT e.JOB
		FROM
			empleados e
		JOIN
			departamentos d
		ON
			e.DEPTNO = d.DEPTNO
		WHERE
			d.LOC = 'CHICAGO'
	)
ORDER BY
	JOB;	