package org.foxsly.cse472.quiz;

/**
 * CSE472Quiz2
 *
 * @author belcheti
 * @version $Id: CSE472Quiz2.java,v 1.0 4/16/12 11:18 AM belcheti Exp $
 */
public class CSE472Quiz2 {
    public static double[] normalize(double[] v) {
        double mag  = Math.sqrt(Math.pow(v[0], 2) + Math.pow(v[1], 2) + Math.pow(v[2], 2));
        double vn[] = {v[0]/mag, v[1]/mag, v[2]/mag};
        return vn;
    }

    public static double dot(double[] a, double[] b) {
        double ans = 0.0;
        for(int i=0; i<3; i++) {
            ans += a[i]*b[i];
        }
        return ans;
    }

    public static double[] ambient(double amb[], double diff[]) {
        double ans[] = {0,0,0};
        for(int i=0; i<3;i++) {
            ans[i] = amb[i]*diff[i];
        }
        return ans;
    }

    public static double[] diffuse(double p[], double pn[], double diff[], double l[], double lcol[]) {
        double ans[] = {0,0,0};
        double lv[] = {0,0,0};
        for(int i=0;i<3;i++) {
            lv[i] = l[i]-p[i];
        }
        double lvn[] = normalize(lv);
        double dotProd = dot(pn, lvn);
        for(int i=0;i<3;i++) {
            ans[i] = diff[i]*lcol[i]*dotProd;
        }
        return ans;
    }

    public static double[] specular(double p[], double pn[], double diff[], double spec[], double shine, double l[], double lcol[], double ambient[]) {
        double ans[] = {0,0,0};
        double lv[] = {0,0,0};
        for(int i=0;i<3;i++) {
            lv[i] = l[i]-p[i];
        }
        double lvn[] = normalize(lv);
        double dotProd = dot(pn, lvn);

        double v1[] = {0,0,0};
        double h[] = {0,0,0};
        for(int i=0;i<3;i++) {
            h[i] = lvn[i];
            //v1[i] = lvn[i] +  
        }
        double sif = Math.pow(dot(pn, h),shine);
        for(int i=0; i<3; i++) {
            ans[i] = lcol[i]*spec[i]*sif;
        }
        return ans;
    }

    public static void main(String[] args){
        /*
         * Question 2
         */
        double diffuse2[] = {.3, .8, .2};
        double ambient2[] = {.1, .1, .15};
        double answer2[] = ambient(diffuse2, ambient2);
        System.out.println("Answer to Q2: " + answer2[0] + ", " + answer2[1] + ", " + answer2[2]);

        /*
         * Question 3
         */
        double point3[] = {3.6, 0.1, -10.0};
        double pnormal3[] = {0.7, -0.3, 0.6};
        double light3[] = {167.0, 154.0, 142.0};
        double diffuse3[] = {.3, .8, .2};
        double lightcol3[] = {.8, .8, .8};
        double answer3[] = diffuse(point3, pnormal3, diffuse3, light3, lightcol3);
        System.out.println("Answer to Q3: " + answer3[0] + ", " + answer3[1] + ", " + answer3[2]);

        /*
         * Question 4
         */
        double light41[] = {154, 156, 129};
        double light42[] = {114, 135, 143};
        double point4[] = {0., 0., 0.};
        double pnormal4[] = {.6, .8, .1};
        double diffuse4[] = {.3, .8, .2};
        double lightcol41[] = {.6, .6, .6};
        double lightcol42[] = {.6, .6, .6};
        double ambient4[] = {.1, .1, .15};
        double answer4[] = ambient(ambient4, diffuse4);
        double diff41[] = diffuse(point4, pnormal4, diffuse4, light41, lightcol41);
        double diff42[] = diffuse(point4, pnormal4, diffuse4, light42, lightcol42);
        for(int i=0; i<3; i++) {
            answer4[i] += diff41[i] + diff42[i];
        }
        System.out.println("Answer to Q4: " + answer4[0] + ", " + answer4[1] + ", " + answer4[2]);

        /*
        * Question 5
        */
        double pix[] = {8.3, 0.0, -10.4};
        double answer5[] = {pix[0]/10.0 * 256., -pix[2]/15.0*256.};
        System.out.println("Answer to Q5: " + answer5[0] + ", " + answer5[1]);

        /*
        * Question 6
        */
        double cmyk[] = {0.35, 0.04, 0.14, 0.62};
        double cmy[] = {cmyk[0]+cmyk[3], cmyk[1]+cmyk[3], cmyk[2]+cmyk[3]};
        double rgb[] = {1.0 - cmy[0], 1.0 - cmy[1], 1.0 - cmy[2]};
        System.out.println("Answer to Q6: " + rgb[0] + ", " + rgb[1] + ", " + rgb[2]);

        /*
         * Question 7
         */
        double point7[] = {1.6, 5.7, 9.2};
        double pnormal7[] = {0.6, -0.6, 0.5};
        double diffuse7[] = {.3, .8, .2};
        double specular7[] = {1., 1., 1.};
        double shininess7 = 2.0;
        double light7[] = {177.0, 154.0, 135.0};
        double lightcol7[] = {0.8, 0.8, 0.8};
        double ambient7[] = {.1, .1, .15};
        double answer7[] = specular(point7, pnormal7, diffuse7, specular7, shininess7, light7, lightcol7, ambient7);
        System.out.println("Answer to Q7: " + answer7[0] + ", " + answer7[1] + ", " + answer7[2]);
        System.out.println("Answer to Q7 could also just be 0,0,0");

        /*
         * Question 8
         */
        //I suck at this bullshit
        System.out.println("Answer to Q8 is half the size of the adjusted image");

        /*
         * Question 9
         */
        System.out.println("Answer to Q9 is I have no clue. Trial by error.");

        /*
        * Question 10
        */
        double cie[] = {0.44, 0.34, 0.15};
        double mag = cie[0]+cie[1]+cie[2];
        double answer10[] = {cie[0]/mag, cie[1]/mag};
        System.out.println("Answer to Q10: " + answer10[0] + ", " + answer10[1]);
    }
}
