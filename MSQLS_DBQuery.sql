USE [master]
GO
/****** Object:  Database [JustFresh]    Script Date: 31/3/2026 03:29:58 ******/
CREATE DATABASE [JustFresh]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'JustFresh', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\JustFresh.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'JustFresh_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\JustFresh_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [JustFresh] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [JustFresh].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [JustFresh] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [JustFresh] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [JustFresh] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [JustFresh] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [JustFresh] SET ARITHABORT OFF 
GO
ALTER DATABASE [JustFresh] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [JustFresh] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [JustFresh] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [JustFresh] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [JustFresh] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [JustFresh] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [JustFresh] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [JustFresh] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [JustFresh] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [JustFresh] SET  ENABLE_BROKER 
GO
ALTER DATABASE [JustFresh] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [JustFresh] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [JustFresh] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [JustFresh] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [JustFresh] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [JustFresh] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [JustFresh] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [JustFresh] SET RECOVERY FULL 
GO
ALTER DATABASE [JustFresh] SET  MULTI_USER 
GO
ALTER DATABASE [JustFresh] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [JustFresh] SET DB_CHAINING OFF 
GO
ALTER DATABASE [JustFresh] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [JustFresh] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [JustFresh] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [JustFresh] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'JustFresh', N'ON'
GO
ALTER DATABASE [JustFresh] SET QUERY_STORE = ON
GO
ALTER DATABASE [JustFresh] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [JustFresh]
GO
/****** Object:  Table [dbo].[LineaCompra]    Script Date: 31/3/2026 03:29:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LineaCompra](
	[ID_OrdenCompra] [int] NOT NULL,
	[ID_Producto] [int] NOT NULL,
	[Cantidad] [int] NOT NULL,
 CONSTRAINT [PK_LineaCompra] PRIMARY KEY CLUSTERED 
(
	[ID_OrdenCompra] ASC,
	[ID_Producto] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[OrdenCompra]    Script Date: 31/3/2026 03:29:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrdenCompra](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[FechaCompra] [nvarchar](12) NOT NULL,
	[Subtotal] [money] NOT NULL,
	[ImpuestosPorCobrar] [money] NOT NULL,
	[Total] [money] NOT NULL,
	[ID_Usuario] [int] NOT NULL,
	[ID_Restaurante] [int] NOT NULL,
 CONSTRAINT [PK_OrdenCompra] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Pais]    Script Date: 31/3/2026 03:29:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Pais](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](25) NOT NULL,
	[Codigo] [int] NOT NULL,
 CONSTRAINT [PK_Pais] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Permiso]    Script Date: 31/3/2026 03:29:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Permiso](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](30) NOT NULL,
	[Descripcion] [nvarchar](60) NOT NULL,
 CONSTRAINT [PK_Permiso] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Producto]    Script Date: 31/3/2026 03:29:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Producto](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](20) NOT NULL,
	[Descripcion] [nvarchar](75) NOT NULL,
	[Precio] [money] NOT NULL,
	[TipoProducto] [int] NOT NULL,
	[TiempoPreparacion] [int] NULL,
	[Cantidad] [int] NULL,
	[Impuesto] [float] NULL,
	[ID_Restaurante] [int] NOT NULL,
 CONSTRAINT [PK_Producto] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Resena]    Script Date: 31/3/2026 03:29:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Resena](
	[ID_Usuario] [int] NOT NULL,
	[ID_OrdenCompra] [int] NOT NULL,
	[ID_Restaurante] [int] NOT NULL,
	[Calificacion] [int] NOT NULL,
 CONSTRAINT [PK_Resena] PRIMARY KEY CLUSTERED 
(
	[ID_Usuario] ASC,
	[ID_OrdenCompra] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Restaurante]    Script Date: 31/3/2026 03:29:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Restaurante](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Nombre] [nvarchar](35) NOT NULL,
	[Localizacion] [nvarchar](75) NOT NULL,
	[TipoRestaurante] [int] NOT NULL,
	[ID_Usuario] [int] NOT NULL,
 CONSTRAINT [PK_Restaurante] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tarjeta]    Script Date: 31/3/2026 03:29:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tarjeta](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Numero] [bigint] NOT NULL,
	[MesVencimiento] [int] NOT NULL,
	[AnoVencimiento] [int] NOT NULL,
	[CodigoSeguridad] [int] NOT NULL,
	[TipoTarjeta] [int] NOT NULL,
	[ID_Usuario] [int] NOT NULL,
 CONSTRAINT [PK_Tarjeta] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 31/3/2026 03:29:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CorreoElectronico] [nvarchar](320) NOT NULL,
	[Contrasena] [nvarchar](50) NOT NULL,
	[Nombre] [nvarchar](40) NOT NULL,
	[ID_PaisOrigen] [int] NOT NULL,
	[TipoUsuario] [int] NOT NULL,
	[IngresoPermitido] [bit] NOT NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UsuarioPermiso]    Script Date: 31/3/2026 03:29:58 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UsuarioPermiso](
	[ID_Usuario] [int] NOT NULL,
	[ID_Permiso] [int] NOT NULL,
 CONSTRAINT [PK_UsuarioPermiso] PRIMARY KEY CLUSTERED 
(
	[ID_Usuario] ASC,
	[ID_Permiso] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (1, 1, 1)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (1, 11, 2)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (2, 2, 2)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (2, 13, 1)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (3, 3, 2)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (4, 4, 2)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (5, 5, 2)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (6, 6, 2)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (7, 2, 1)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (7, 7, 1)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (8, 8, 2)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (9, 9, 2)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (9, 15, 1)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (10, 10, 1)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (11, 12, 2)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (12, 7, 1)
GO
INSERT [dbo].[LineaCompra] ([ID_OrdenCompra], [ID_Producto], [Cantidad]) VALUES (12, 14, 3)
GO
SET IDENTITY_INSERT [dbo].[OrdenCompra] ON 
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (1, N'15/01/2024', 15000.0000, 1950.0000, 16950.0000, 7, 1)
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (2, N'20/01/2024', 13000.0000, 1690.0000, 14690.0000, 7, 2)
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (3, N'03/02/2024', 19000.0000, 2470.0000, 21470.0000, 8, 3)
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (4, N'14/02/2024', 24000.0000, 3120.0000, 27120.0000, 8, 4)
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (5, N'28/02/2024', 9000.0000, 1170.0000, 10170.0000, 9, 5)
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (6, N'10/03/2024', 18000.0000, 2340.0000, 20340.0000, 9, 6)
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (7, N'22/03/2024', 14500.0000, 1885.0000, 16385.0000, 10, 7)
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (8, N'05/04/2024', 19000.0000, 2470.0000, 21470.0000, 10, 8)
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (9, N'18/04/2024', 10500.0000, 1365.0000, 11865.0000, 11, 9)
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (10, N'01/05/2024', 8500.0000, 1105.0000, 9605.0000, 11, 10)
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (11, N'15/05/2024', 7000.0000, 910.0000, 7910.0000, 12, 11)
GO
INSERT [dbo].[OrdenCompra] ([ID], [FechaCompra], [Subtotal], [ImpuestosPorCobrar], [Total], [ID_Usuario], [ID_Restaurante]) VALUES (12, N'30/05/2024', 15700.0000, 2041.0000, 17741.0000, 12, 12)
GO
SET IDENTITY_INSERT [dbo].[OrdenCompra] OFF
GO
SET IDENTITY_INSERT [dbo].[Pais] ON 
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (1, N'Costa Rica', 506)
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (2, N'México', 52)
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (3, N'Colombia', 57)
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (4, N'Argentina', 54)
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (5, N'España', 34)
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (6, N'Perú', 51)
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (7, N'Chile', 56)
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (8, N'Ecuador', 593)
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (9, N'Guatemala', 502)
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (10, N'Panamá', 507)
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (11, N'Venezuela', 58)
GO
INSERT [dbo].[Pais] ([ID], [Nombre], [Codigo]) VALUES (12, N'Uruguay', 598)
GO
SET IDENTITY_INSERT [dbo].[Pais] OFF
GO
SET IDENTITY_INSERT [dbo].[Permiso] ON 
GO
INSERT [dbo].[Permiso] ([ID], [Nombre], [Descripcion]) VALUES (1, N'ORDENAR_PRODUCTOS', N'Permite el acceso al módulo de compras')
GO
INSERT [dbo].[Permiso] ([ID], [Nombre], [Descripcion]) VALUES (2, N'REPORTERIA', N'Permite el acceso al módulo de reportería')
GO
INSERT [dbo].[Permiso] ([ID], [Nombre], [Descripcion]) VALUES (3, N'MANTENIMIENTO_RESTAURANTE', N'Permite el acceso a los módulos de mantenimineto')
GO
SET IDENTITY_INSERT [dbo].[Permiso] OFF
GO
SET IDENTITY_INSERT [dbo].[Producto] ON 
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (1, N'Lasaña Boloñesa', N'Lasaña con salsa boloñesa, queso mozzarella y albahaca fresca', 8500.0000, 2, 25, NULL, NULL, 1)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (2, N'Hamburguesa Clásica', N'Hamburguesa de res con lechuga, tomate, cebolla y salsa especial', 6500.0000, 2, 15, NULL, NULL, 2)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (3, N'Pizza Margarita', N'Pizza con salsa de tomate, mozzarella fresca y albahaca', 7000.0000, 2, 20, NULL, NULL, 3)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (4, N'Sushi Variado', N'Bandeja de 12 piezas de sushi variado con salmón y atún', 12000.0000, 2, 30, NULL, NULL, 4)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (5, N'Tres Leches', N'Pastel de tres leches con crema batida y canela', 4500.0000, 2, 35, NULL, NULL, 5)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (6, N'Fetuccini Alfredo', N'Pasta fetuccini con salsa alfredo, pollo y champiñones', 9000.0000, 2, 20, NULL, NULL, 6)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (7, N'Doble Smash Burger', N'Doble carne smash con queso cheddar y tocino crujiente', 7500.0000, 2, 12, NULL, NULL, 7)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (8, N'Pizza Pepperoni XL', N'Pizza extra grande de pepperoni con borde de queso', 9500.0000, 2, 25, NULL, NULL, 8)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (9, N'Té Verde Matcha', N'Botella de té verde matcha orgánico de 500ml', 2500.0000, 1, NULL, 50, 0.13, 9)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (10, N'Brownie Artesanal', N'Caja de 6 brownies de chocolate belga con nueces', 5000.0000, 1, NULL, 30, 0.13, 10)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (11, N'Agua Mineral', N'Botella de agua mineral con gas de 750ml', 1500.0000, 1, NULL, 100, 0.13, 1)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (12, N'Galletas Italianas', N'Paquete de galletas amaretti italianas importadas', 3500.0000, 1, NULL, 40, 0.13, 11)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (13, N'Refresco Natural', N'Botella de refresco de cas natural de 600ml', 2000.0000, 1, NULL, 80, 0.13, 2)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (14, N'Jugo de Naranja', N'Botella de jugo de naranja recién exprimido de 500ml', 2200.0000, 1, NULL, 60, 0.13, 12)
GO
INSERT [dbo].[Producto] ([ID], [Nombre], [Descripcion], [Precio], [TipoProducto], [TiempoPreparacion], [Cantidad], [Impuesto], [ID_Restaurante]) VALUES (15, N'Ramen Tonkotsu', N'Ramen con caldo de cerdo, huevo marinado y chashu', 8000.0000, 2, 28, NULL, NULL, 9)
GO
SET IDENTITY_INSERT [dbo].[Producto] OFF
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (7, 1, 1, 5)
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (7, 2, 2, 4)
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (8, 3, 3, 5)
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (8, 4, 4, 4)
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (9, 5, 5, 3)
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (9, 6, 6, 5)
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (10, 7, 7, 4)
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (10, 8, 8, 5)
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (11, 9, 9, 4)
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (11, 10, 10, 3)
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (12, 11, 11, 5)
GO
INSERT [dbo].[Resena] ([ID_Usuario], [ID_OrdenCompra], [ID_Restaurante], [Calificacion]) VALUES (12, 12, 12, 4)
GO
SET IDENTITY_INSERT [dbo].[Restaurante] ON 
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (1, N'La Trattoria', N'San José, Escazú, Plaza Itskatzú Local 12', 1, 3)
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (2, N'Burger House CR', N'San José, Santa Ana, Centro Comercial Terrazas', 2, 3)
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (3, N'Pizza Nostra', N'Heredia, San Pablo, Centro Comercial Oxígeno', 3, 3)
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (4, N'Sakura Sushi', N'San José, Curridabat, Multiplaza del Este', 4, 4)
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (5, N'Dulce Tentación', N'Cartago, Centro, Avenida 2 Calle 5', 5, 4)
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (6, N'Pasta & Vino', N'Alajuela, Ciudad Quesada, Plaza San Carlos', 1, 4)
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (7, N'La Hamburguesa Feliz', N'San José, Sabana Norte, frente al Parque La Sabana', 2, 5)
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (8, N'Pizzería Don Mario', N'Guanacaste, Liberia, Centro Comercial Plaza Liberia', 3, 5)
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (9, N'Tokio Express', N'San José, Barrio Escalante, Calle 33', 4, 5)
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (10, N'Pastelería Abuela Rosa', N'Puntarenas, Jacó, Calle Principal Local 8', 5, 6)
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (11, N'Trattoria Bella Notte', N'Limón, Centro, Avenida 1 Calle 3', 1, 6)
GO
INSERT [dbo].[Restaurante] ([ID], [Nombre], [Localizacion], [TipoRestaurante], [ID_Usuario]) VALUES (12, N'Burger Planet', N'San José, Tibás, Centro Comercial El Pueblo', 2, 6)
GO
SET IDENTITY_INSERT [dbo].[Restaurante] OFF
GO
SET IDENTITY_INSERT [dbo].[Tarjeta] ON 
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (1, 4111222233334444, 12, 2027, 123, 1, 7)
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (2, 5200333344445555, 6, 2028, 456, 2, 7)
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (3, 4000111122223333, 3, 2026, 789, 1, 8)
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (4, 5100444455556666, 9, 2027, 321, 2, 8)
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (5, 4222333344445555, 11, 2029, 654, 1, 9)
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (6, 5300555566667777, 1, 2028, 987, 2, 10)
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (7, 4333444455556666, 7, 2027, 111, 1, 10)
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (8, 5400666677778888, 5, 2026, 222, 2, 11)
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (9, 4444555566667777, 8, 2028, 333, 1, 11)
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (10, 5500777788889999, 10, 2029, 444, 2, 12)
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (11, 4555666677778888, 2, 2027, 555, 1, 12)
GO
INSERT [dbo].[Tarjeta] ([ID], [Numero], [MesVencimiento], [AnoVencimiento], [CodigoSeguridad], [TipoTarjeta], [ID_Usuario]) VALUES (12, 5600888899990000, 4, 2028, 666, 2, 9)
GO
SET IDENTITY_INSERT [dbo].[Tarjeta] OFF
GO
SET IDENTITY_INSERT [dbo].[Usuario] ON 
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (1, N'admin@justfresh.com', N'Admin123', N'Carlos Rodríguez', 1, 1, 1)
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (2, N'superadmin@justfresh.com', N'Super456', N'María Fernández', 5, 1, 1)
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (3, N'gerente1@justfresh.com', N'Gerente123', N'José García López', 2, 2, 1)
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (4, N'gerente2@justfresh.com', N'Gerente456', N'Ana Martínez Ruiz', 3, 2, 1)
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (5, N'gerente3@justfresh.com', N'Gerente789', N'Pedro Sánchez Mora', 4, 2, 1)
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (6, N'gerente4@justfresh.com', N'Gerente012', N'Lucía Herrera Solís', 6, 2, 1)
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (7, N'juan.perez@correo.com', N'Juan1234', N'Juan Pérez Rojas', 1, 3, 1)
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (8, N'laura.gomez@correo.com', N'Laura567', N'Laura Gómez Castro', 7, 3, 1)
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (9, N'diego.mora@correo.com', N'Diego890', N'Diego Mora Vargas', 8, 3, 1)
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (10, N'sofia.rios@correo.com', N'Sofia1234', N'Sofía Ríos Delgado', 9, 3, 1)
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (11, N'andres.lopez@correo.com', N'Andres567', N'Andrés López Núñez', 10, 3, 1)
GO
INSERT [dbo].[Usuario] ([ID], [CorreoElectronico], [Contrasena], [Nombre], [ID_PaisOrigen], [TipoUsuario], [IngresoPermitido]) VALUES (12, N'camila.vega@correo.com', N'Camila890', N'Camila Vega Jiménez', 11, 3, 0)
GO
SET IDENTITY_INSERT [dbo].[Usuario] OFF
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (1, 2)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (1, 3)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (2, 2)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (2, 3)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (3, 3)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (4, 3)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (5, 3)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (6, 3)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (7, 1)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (8, 1)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (9, 1)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (10, 1)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (11, 1)
GO
INSERT [dbo].[UsuarioPermiso] ([ID_Usuario], [ID_Permiso]) VALUES (12, 1)
GO
ALTER TABLE [dbo].[LineaCompra]  WITH CHECK ADD  CONSTRAINT [FK_LineaCompra_OrdenCompra] FOREIGN KEY([ID_OrdenCompra])
REFERENCES [dbo].[OrdenCompra] ([ID])
GO
ALTER TABLE [dbo].[LineaCompra] CHECK CONSTRAINT [FK_LineaCompra_OrdenCompra]
GO
ALTER TABLE [dbo].[LineaCompra]  WITH CHECK ADD  CONSTRAINT [FK_LineaCompra_Producto] FOREIGN KEY([ID_Producto])
REFERENCES [dbo].[Producto] ([ID])
GO
ALTER TABLE [dbo].[LineaCompra] CHECK CONSTRAINT [FK_LineaCompra_Producto]
GO
ALTER TABLE [dbo].[OrdenCompra]  WITH CHECK ADD  CONSTRAINT [FK_OrdenCompra_Restaurante] FOREIGN KEY([ID_Restaurante])
REFERENCES [dbo].[Restaurante] ([ID])
GO
ALTER TABLE [dbo].[OrdenCompra] CHECK CONSTRAINT [FK_OrdenCompra_Restaurante]
GO
ALTER TABLE [dbo].[OrdenCompra]  WITH CHECK ADD  CONSTRAINT [FK_OrdenCompra_Usuario] FOREIGN KEY([ID_Usuario])
REFERENCES [dbo].[Usuario] ([ID])
GO
ALTER TABLE [dbo].[OrdenCompra] CHECK CONSTRAINT [FK_OrdenCompra_Usuario]
GO
ALTER TABLE [dbo].[Producto]  WITH CHECK ADD  CONSTRAINT [FK_Producto_Restaurante] FOREIGN KEY([ID_Restaurante])
REFERENCES [dbo].[Restaurante] ([ID])
GO
ALTER TABLE [dbo].[Producto] CHECK CONSTRAINT [FK_Producto_Restaurante]
GO
ALTER TABLE [dbo].[Resena]  WITH CHECK ADD  CONSTRAINT [FK_Resena_OrdenCompra] FOREIGN KEY([ID_OrdenCompra])
REFERENCES [dbo].[OrdenCompra] ([ID])
GO
ALTER TABLE [dbo].[Resena] CHECK CONSTRAINT [FK_Resena_OrdenCompra]
GO
ALTER TABLE [dbo].[Resena]  WITH CHECK ADD  CONSTRAINT [FK_Resena_Restaurante] FOREIGN KEY([ID_Restaurante])
REFERENCES [dbo].[Restaurante] ([ID])
GO
ALTER TABLE [dbo].[Resena] CHECK CONSTRAINT [FK_Resena_Restaurante]
GO
ALTER TABLE [dbo].[Resena]  WITH CHECK ADD  CONSTRAINT [FK_Resena_Usuario] FOREIGN KEY([ID_Usuario])
REFERENCES [dbo].[Usuario] ([ID])
GO
ALTER TABLE [dbo].[Resena] CHECK CONSTRAINT [FK_Resena_Usuario]
GO
ALTER TABLE [dbo].[Restaurante]  WITH CHECK ADD  CONSTRAINT [FK_Restaurante_Usuario] FOREIGN KEY([ID_Usuario])
REFERENCES [dbo].[Usuario] ([ID])
GO
ALTER TABLE [dbo].[Restaurante] CHECK CONSTRAINT [FK_Restaurante_Usuario]
GO
ALTER TABLE [dbo].[Tarjeta]  WITH CHECK ADD  CONSTRAINT [FK_Tarjeta_Usuario] FOREIGN KEY([ID_Usuario])
REFERENCES [dbo].[Usuario] ([ID])
GO
ALTER TABLE [dbo].[Tarjeta] CHECK CONSTRAINT [FK_Tarjeta_Usuario]
GO
ALTER TABLE [dbo].[Usuario]  WITH CHECK ADD  CONSTRAINT [FK_Usuario_Pais] FOREIGN KEY([ID_PaisOrigen])
REFERENCES [dbo].[Pais] ([ID])
GO
ALTER TABLE [dbo].[Usuario] CHECK CONSTRAINT [FK_Usuario_Pais]
GO
ALTER TABLE [dbo].[UsuarioPermiso]  WITH CHECK ADD  CONSTRAINT [FK_UsuarioPermiso_Permiso] FOREIGN KEY([ID_Permiso])
REFERENCES [dbo].[Permiso] ([ID])
GO
ALTER TABLE [dbo].[UsuarioPermiso] CHECK CONSTRAINT [FK_UsuarioPermiso_Permiso]
GO
ALTER TABLE [dbo].[UsuarioPermiso]  WITH CHECK ADD  CONSTRAINT [FK_UsuarioPermiso_Usuario] FOREIGN KEY([ID_Usuario])
REFERENCES [dbo].[Usuario] ([ID])
GO
ALTER TABLE [dbo].[UsuarioPermiso] CHECK CONSTRAINT [FK_UsuarioPermiso_Usuario]
GO
USE [master]
GO
ALTER DATABASE [JustFresh] SET  READ_WRITE 
GO
