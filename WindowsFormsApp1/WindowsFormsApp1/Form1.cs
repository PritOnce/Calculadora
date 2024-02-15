using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WindowsFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
            TableImages(); 
        }

        private void TableImages()
        {
            Image image = Image.FromFile("../../imagenes/briefcaseGood.png");

            for (int row = 0; row < tableLayoutPanel1.RowCount; row++)
            {
                for (int col = 0; col < tableLayoutPanel1.ColumnCount; col++)
                {
                    PictureBox pictureBox = new PictureBox();
                    pictureBox.Dock = DockStyle.Fill;
                    pictureBox.Image = image;
                    tableLayoutPanel1.Controls.Add(pictureBox, col, row);
                }
            }
        }
    }
}
