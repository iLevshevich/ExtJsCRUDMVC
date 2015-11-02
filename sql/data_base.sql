###Create data base [ExtJsTest] and add simple table:

CREATE TABLE [dbo].[Users](
	[id] [uniqueidentifier] NOT NULL,
	[firstname] [nchar](30) NOT NULL,
	[lastname] [nchar](30) NOT NULL,
	[telephone] [nchar](15) NOT NULL,
	[email] [nchar](30) NOT NULL,
	[password] [nchar](100) NOT NULL,
	[created] [datetime] NOT NULL,
	[modified] [datetime] NOT NULL,
  CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED;

ALTER TABLE [dbo].[Users] ADD CONSTRAINT [DF_Users_id]  DEFAULT (newid()) FOR [id];
ALTER TABLE [dbo].[Users] ADD CONSTRAINT [DF_Users_created]  DEFAULT (getdate()) FOR [created];
ALTER TABLE [dbo].[Users] ADD CONSTRAINT [DF_Users_modified]  DEFAULT (getdate()) FOR [modified];

CREATE TRIGGER [dbo].[update_modified] 
   ON [dbo].[Users]
   AFTER UPDATE
AS 
BEGIN
	SET NOCOUNT ON;
	BEGIN TRY
		DECLARE @id AS uniqueidentifier;
		SELECT @id = [id]
		FROM INSERTED;
    
		UPDATE [dbo].[Users]
		SET [modified] = (getdate())
		WHERE [id] = @id;
	END TRY
	BEGIN CATCH
		DECLARE @ErrorMessage nvarchar(4000);  
		DECLARE @ErrorSeverity int;
		SELECT @ErrorMessage = ERROR_MESSAGE(), @ErrorSeverity = ERROR_SEVERITY();
		RAISERROR(@ErrorMessage, @ErrorSeverity, 1);
	END CATCH;
END