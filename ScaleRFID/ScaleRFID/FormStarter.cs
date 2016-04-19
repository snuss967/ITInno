using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ScaleRFID
{
    public enum LaunchTypes
    {
        Trash,
        Recycle
    }
    class FormStarter
    {
        public static LaunchTypes launcher = LaunchTypes.Trash;
        public static void Launch(LaunchTypes LauncherType)
        {
            launcher = LauncherType;
        }
    }
}
