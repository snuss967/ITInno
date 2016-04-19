namespace ScaleRFID
{
    partial class Form1
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Form1));
            this.SendBTN = new System.Windows.Forms.Button();
            this.CollectBTN = new System.Windows.Forms.Button();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // SendBTN
            // 
            this.SendBTN.Location = new System.Drawing.Point(294, 197);
            this.SendBTN.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.SendBTN.Name = "SendBTN";
            this.SendBTN.Size = new System.Drawing.Size(100, 26);
            this.SendBTN.TabIndex = 0;
            this.SendBTN.Text = "SEND ALL";
            this.SendBTN.UseVisualStyleBackColor = true;
            this.SendBTN.Click += new System.EventHandler(this.SendBTN_Click);
            // 
            // CollectBTN
            // 
            this.CollectBTN.Location = new System.Drawing.Point(64, 197);
            this.CollectBTN.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.CollectBTN.Name = "CollectBTN";
            this.CollectBTN.Size = new System.Drawing.Size(100, 26);
            this.CollectBTN.TabIndex = 1;
            this.CollectBTN.Text = "COLLECT";
            this.CollectBTN.UseVisualStyleBackColor = true;
            this.CollectBTN.Click += new System.EventHandler(this.CollectBTN_Click);
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(64, 95);
            this.textBox1.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(332, 20);
            this.textBox1.TabIndex = 2;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(464, 303);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.CollectBTN);
            this.Controls.Add(this.SendBTN);
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.Name = "Form1";
            this.Text = "Integrated Refuse Solutions";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button SendBTN;
        private System.Windows.Forms.Button CollectBTN;
        private System.Windows.Forms.TextBox textBox1;
    }
}

