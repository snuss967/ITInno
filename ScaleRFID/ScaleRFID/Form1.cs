using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.IO;
using System.Collections;
using RestSharp;
using System.Diagnostics;
using System.Threading;

namespace ScaleRFID
{
    public partial class Form1 : Form
    {
        ArrayList collections = new ArrayList();
        string lastRFID = null;
        string currentRFID = null;
        double oldWeight = 0.0;
        double newWeight = 0.0;
        LaunchTypes launcherType = LaunchTypes.Trash;
        public Form1()
        {
            InitializeComponent();
            launcherType = FormStarter.launcher;
            
        }

        private void CollectBTN_Click(object sender, EventArgs e)
        {
            RFIDUserNameMapping mapper = RFIDUserNameMapping.getInstance();
            doPython();
            double collectionWeight;
            string text = textBox1.Text;
            //will send last RFID after we calculate the new weight
            lastRFID = currentRFID;
            currentRFID = text;
            textBox1.Text = "";
            if (lastRFID == null)
            {
                lastRFID = currentRFID;
            }
            int RFID = Int32.Parse(lastRFID);
            //code to call python scale
            //read in weight from the scale
            oldWeight = newWeight;
            string line;
            Thread.Sleep(150);
            using (StreamReader reader = new StreamReader("C:\\Users\\Spencer\\Desktop\\WeightInformation.txt"))
            {
                line = reader.ReadLine();
            }
            newWeight = Double.Parse(line);
            collectionWeight = newWeight - oldWeight;
            var client = new RestClient("http://localhost:9998");
            var request = new RestRequest("/trash/{RFID}/{WEIGHT}/{USERNAME}", Method.POST);
            if (launcherType.Equals(LaunchTypes.Recycle))
            {
                request = new RestRequest("/recycle/{RFID}/{WEIGHT}/{USERNAME}", Method.POST);
            }
            request.AddUrlSegment("RFID", lastRFID);
            string userName = mapper.getUserName(Int32.Parse(lastRFID));
            Console.WriteLine(collectionWeight.ToString());
            request.AddUrlSegment("WEIGHT", collectionWeight.ToString());
            request.AddUrlSegment("USERNAME", userName);
            client.ExecuteAsync(request, response => {
                Console.WriteLine(response.Content);
            });
            Console.ReadLine();

        }
        static void doPython()
        {
            Process.Start(@"C:\Users\Spencer\Documents\Visual Studio 2015\Projects\ReadInWeight\ReadInWeight\dist\PythonApplication1.exe");
        }

        private void SendBTN_Click(object sender, EventArgs e)
        {
           
        }
    }
}
