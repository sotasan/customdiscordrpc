#define MyAppName "CustomDiscordRPC"
#define MyAppVersion "3.0.0"
#define MyAppPublisher "PryosCode"
#define MyAppURL "https://github.com/PryosCode/CustomDiscordRPC"
#define MyAppExeName "CustomDiscordRPC.exe"

[Setup]
AppId={{E519EEC6-80F9-4D69-B253-423F9421ECAE}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={autopf}\{#MyAppName}
DisableProgramGroupPage=yes
LicenseFile=assets\LICENSE.rtf
OutputDir=dist
OutputBaseFilename=CustomDiscordRPC
SetupIconFile=assets\logo.ico
Compression=lzma
SolidCompression=yes
WizardStyle=modern

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "bin\Release\net6.0-windows\publish\{#MyAppExeName}"; DestDir: "{app}"; Flags: ignoreversion
Source: "bin\Release\net6.0-windows\publish\CustomDiscordRPC.deps.json"; DestDir: "{app}"; Flags: ignoreversion
Source: "bin\Release\net6.0-windows\publish\CustomDiscordRPC.dll"; DestDir: "{app}"; Flags: ignoreversion
Source: "bin\Release\net6.0-windows\publish\CustomDiscordRPC.runtimeconfig.json"; DestDir: "{app}"; Flags: ignoreversion
Source: "bin\Release\net6.0-windows\publish\DiscordRPC.dll"; DestDir: "{app}"; Flags: ignoreversion
Source: "bin\Release\net6.0-windows\publish\INIFileParser.dll"; DestDir: "{app}"; Flags: ignoreversion
Source: "bin\Release\net6.0-windows\publish\Newtonsoft.Json.dll"; DestDir: "{app}"; Flags: ignoreversion

[Icons]
Name: "{autoprograms}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{autodesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, '&', '&&')}}"; Flags: nowait postinstall skipifsilent