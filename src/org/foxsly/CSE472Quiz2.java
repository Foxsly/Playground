package org.foxsly;

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
        double point3[] = {-3.4, 8.5, -1.9};
        double pnormal3[] = {0.2, 0.7, 0.7};
        double diffuse3[] = {.3, .8, .2};
        //double specular3[] = {.1, .1, .1};
        //double ambient3[] = {.1, .1, .1};
        double light3[] = {195.0, 157.0, 190.0};
        double lightcol3[] = {.8, .8, .8};
        double answer3[] = diffuse(point3, pnormal3, diffuse3, light3, lightcol3);
        System.out.println("Answer to Q3: " + answer3[0] + ", " + answer3[1] + ", " + answer3[2]);

        /*
         * Question 4
         */
        double point4[] = {0., 0., 0.};
        double pnormal4[] = {.6, .8, .1};
        double diffuse4[] = {.3, .8, .2};
        double light41[] = {167., 158., 146.};
        double lightcol41[] = {.6, .6, .6};
        double light42[] = {142., 110., 143.};
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
        /*
        double tl[] = {0., 2., 0.};
        double tr[] = {3., 2., 1.};
        double bl[] = {0., 1., 0.};
        double br[] = {3., 0., 1.};
        double pt[] = {1.5, 1.5, 0.5};
        */
        //Calculate left side
        double pix[] = {5.3, 0, -9.0};
        double answer5[] = {pix[0]/10.0 * 256., -pix[2]/15.0*256.};
        System.out.println("Answer to Q5: " + answer5[0] + ", " + answer5[1]);

        /*
        * Question 6
        */

    }
}
