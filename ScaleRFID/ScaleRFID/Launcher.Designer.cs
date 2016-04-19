namespace ScaleRFID
{
    partial class Launcher
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Launcher));
            this.welcomeTXT = new System.Windows.Forms.Label();
            this.recycleLaunchBTN = new System.Windows.Forms.Button();
            this.trashLaunchBTN = new System.Windows.Forms.Button();
            this.subWelcomeTXT = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // welcomeTXT
            // 
            this.welcomeTXT.AutoSize = true;
            this.welcomeTXT.Location = new System.Drawing.Point(90, 54);
            this.welcomeTXT.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.welcomeTXT.Name = "welcomeTXT";
            this.welcomeTXT.Size = new System.Drawing.Size(157, 13);
            this.welcomeTXT.TabIndex = 0;
            this.welcomeTXT.Text = "Welcome To The Trash System";
            this.welcomeTXT.Click += new System.EventHandler(this.label1_Click);
            // 
            // recycleLaunchBTN
            // 
            this.recycleLaunchBTN.Location = new System.Drawing.Point(248, 113);
            this.recycleLaunchBTN.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.recycleLaunchBTN.Name = "recycleLaunchBTN";
            this.recycleLaunchBTN.Size = new System.Drawing.Size(62, 35);
            this.recycleLaunchBTN.TabIndex = 1;
            this.recycleLaunchBTN.Text = "Recycling";
            this.recycleLaunchBTN.UseVisualStyleBackColor = true;
            this.recycleLaunchBTN.Click += new System.EventHandler(this.recycleLaunchBTN_Click);
            // 
            // trashLaunchBTN
            // 
            this.trashLaunchBTN.Location = new System.Drawing.Point(43, 113);
            this.trashLaunchBTN.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.trashLaunchBTN.Name = "trashLaunchBTN";
            this.trashLaunchBTN.Size = new System.Drawing.Size(62, 35);
            this.trashLaunchBTN.TabIndex = 2;
            this.trashLaunchBTN.Text = "Trash";
            this.trashLaunchBTN.UseVisualStyleBackColor = true;
            this.trashLaunchBTN.Click += new System.EventHandler(this.trashLaunchBTN_Click);
            // 
            // subWelcomeTXT
            // 
            this.subWelcomeTXT.AutoSize = true;
            this.subWelcomeTXT.Location = new System.Drawing.Point(40, 79);
            this.subWelcomeTXT.Margin = new System.Windows.Forms.Padding(2, 0, 2, 0);
            this.subWelcomeTXT.Name = "subWelcomeTXT";
            this.subWelcomeTXT.Size = new System.Drawing.Size(270, 13);
            this.subWelcomeTXT.TabIndex = 3;
            this.subWelcomeTXT.Text = "Will This Be a Trash Truck Or a Recycling Truck Today";
            // 
            // Launcher
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Window;
            this.ClientSize = new System.Drawing.Size(345, 257);
            this.Controls.Add(this.subWelcomeTXT);
            this.Controls.Add(this.trashLaunchBTN);
            this.Controls.Add(this.recycleLaunchBTN);
            this.Controls.Add(this.welcomeTXT);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.Name = "Launcher";
            this.ShowInTaskbar = false;
            this.Text = "Integrated Refuse Solutions Launcher";
            this.Load += new System.EventHandler(this.Launcher_Load);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label welcomeTXT;
        private System.Windows.Forms.Button recycleLaunchBTN;
        private System.Windows.Forms.Button trashLaunchBTN;
        private System.Windows.Forms.Label subWelcomeTXT;
    }
}