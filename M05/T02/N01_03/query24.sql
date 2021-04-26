USE dbsegundo;
	
-- Nombre: ENAME
-- Salario: SAL

SELECT
	CONCAT('Nombre: ', ENAME) AS NOMBRE,
	CONCAT('Salario: ', SAL) AS SALARIO
FROM
	empleados;