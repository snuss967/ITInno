using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ScaleRFID
{
    public partial class Launcher : Form
    {
        public Launcher()
        {
            InitializeComponent();
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void trashLaunchBTN_Click(object sender, EventArgs e)
        {
            FormStarter.Launch(LaunchTypes.Trash);
            Form1 form = new Form1();
            form.Show();
            this.Hide();
        }

        private void recycleLaunchBTN_Click(object sender, EventArgs e)
        {
            FormStarter.Launch(LaunchTypes.Recycle);
            Form1 form = new Form1();
            form.Show();
            this.Hide();
        }

        private void Launcher_Load(object sender, EventArgs e)
        {

        }
    }
}
