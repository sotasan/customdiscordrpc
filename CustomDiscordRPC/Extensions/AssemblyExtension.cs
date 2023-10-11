namespace CustomDiscordRPC.Extensions;

using System.Reflection;

public static class AssemblyExtension {

    public static Stream GetAsset(this Assembly assembly, string name) {
        return assembly.GetManifestResourceStream($"CustomDiscordRPC.Assets.{name}")!;
    }

}