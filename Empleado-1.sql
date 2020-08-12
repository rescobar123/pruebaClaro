
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";



CREATE TABLE `Empleado` (
  `IdEmpleado` int(5) NOT NULL,
  `EmpleadoNombre` varchar(50) NOT NULL,
  `EmpleadoDireccion` varchar(30) NOT NULL,
  `EmpleadoRol` varchar(20) NOT NULL,
  `EmpleadoEmail` varchar(50) NOT NULL,
  `EmpleadoPassword` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `Empleado` (`IdEmpleado`, `EmpleadoNombre`, `EmpleadoDireccion`, `EmpleadoRol`, `EmpleadoEmail`, `EmpleadoPassword`) VALUES
(5, 'Robin Eriberto Escobar Solis', 'Zona 1', 'Administrador', 'rescobars@miumg.edu.gt', 'Robinsolis');

ces de la tabla `Empleado`

ALTER TABLE `Empleado`
  ADD PRIMARY KEY (`IdEmpleado`),
  ADD UNIQUE KEY `EmpleadoEmail` (`EmpleadoEmail`);


ALTER TABLE `Empleado`
  MODIFY `IdEmpleado` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

