USE [master]
GO
/****** Object:  Database [ItemManagement]    Script Date: 30/09/2020 9:33:11 SA ******/
CREATE DATABASE [ItemManagement]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ItemManagement', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\ItemManagement.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'ItemManagement_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.SQLEXPRESS\MSSQL\DATA\ItemManagement_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [ItemManagement] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ItemManagement].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ItemManagement] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ItemManagement] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ItemManagement] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ItemManagement] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ItemManagement] SET ARITHABORT OFF 
GO
ALTER DATABASE [ItemManagement] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [ItemManagement] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ItemManagement] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ItemManagement] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ItemManagement] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ItemManagement] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ItemManagement] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ItemManagement] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ItemManagement] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ItemManagement] SET  DISABLE_BROKER 
GO
ALTER DATABASE [ItemManagement] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ItemManagement] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ItemManagement] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ItemManagement] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ItemManagement] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ItemManagement] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ItemManagement] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ItemManagement] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ItemManagement] SET  MULTI_USER 
GO
ALTER DATABASE [ItemManagement] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ItemManagement] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ItemManagement] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ItemManagement] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [ItemManagement] SET DELAYED_DURABILITY = DISABLED 
GO
USE [ItemManagement]
GO
/****** Object:  Table [dbo].[tblItems]    Script Date: 30/09/2020 9:33:11 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblItems](
	[itemCode] [varchar](10) NOT NULL,
	[itemName] [nvarchar](50) NOT NULL,
	[unit] [varchar](50) NOT NULL,
	[price] [float] NOT NULL,
	[supplying] [bit] NOT NULL,
	[supCode] [varchar](10) NOT NULL,
 CONSTRAINT [PK_tblItems] PRIMARY KEY CLUSTERED 
(
	[itemCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblSuppliers]    Script Date: 30/09/2020 9:33:11 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblSuppliers](
	[supCode] [varchar](10) NOT NULL,
	[supName] [nvarchar](50) NOT NULL,
	[address] [nvarchar](50) NULL,
	[collaborating] [bit] NOT NULL,
 CONSTRAINT [PK_tblSuppliers] PRIMARY KEY CLUSTERED 
(
	[supCode] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblUsers]    Script Date: 30/09/2020 9:33:11 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUsers](
	[userID] [varchar](10) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [varchar](50) NOT NULL,
	[status] [bit] NOT NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'0001', N'GTX1080', N'12', 178.34, 1, N'PQ')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'0002', N'Apple', N'2 tones', 1645, 0, N'CC')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'0003', N'Ruby', N'3', 16351.14, 1, N'ZX')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'0004', N'Orange', N'0.5 tone', 700.12, 1, N'CC')
INSERT [dbo].[tblItems] ([itemCode], [itemName], [unit], [price], [supplying], [supCode]) VALUES (N'0005', N'Quantum', N'3', 800.1, 1, N'PQ')
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'AA', N'Arone Aquare', N'1982 Broson, DC, USA', 0)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'CC', N'CC_CanadaC2', N'12 tp HCM', 1)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'PQ', N'Phantim Quatinum', N'14 Cong Hoa, Tan Binh, HCM, VN', 1)
INSERT [dbo].[tblSuppliers] ([supCode], [supName], [address], [collaborating]) VALUES (N'ZX', N'Zoom Xaphia', N'1231, Okioto, Tokyo, Japan', 1)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [status]) VALUES (N'knt', N'kieu nhat tan', N'123', 1)
ALTER TABLE [dbo].[tblItems]  WITH CHECK ADD  CONSTRAINT [FK_tblItems_tblSuppliers] FOREIGN KEY([supCode])
REFERENCES [dbo].[tblSuppliers] ([supCode])
GO
ALTER TABLE [dbo].[tblItems] CHECK CONSTRAINT [FK_tblItems_tblSuppliers]
GO
USE [master]
GO
ALTER DATABASE [ItemManagement] SET  READ_WRITE 
GO
