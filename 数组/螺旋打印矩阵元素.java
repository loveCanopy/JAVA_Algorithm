在输出的时候可以给水平方向和垂直方向各设置两个坐标，start_x, end_x, start_y, end_y, 
分别表示当前水平方向输出区间应该在start_x和end_x之间，垂直方向输出区间在start_y和end_y直接，
每次转弯的时候只需要改变区间的边界就可以了。具体代码如下：
int     arr[6][5]= 
{{1,           16,           3,           2,             17}, 
{8,           6,             4,           3,             23}, 
{2,           5,             7,           8,             12}, 
{21,         2,             4,           6,             13}, 
{11,       111,           111,       132,         12}, 
{31,       311,           4111,     332,         32} 
};      
void main()
{
        // 初始的区间坐标
    int startX = 0, endX = 4;
    int startY = 0, endY = 5;
    
    while(startX<=endX && startY<=endY)  // 循环条件
    {
        int i;
        for(i=startX; i<=endX; i++)  // 输出上边的行
            cout << arr[startY][i] << " ";
        startY ++;         // 行的开始坐标增加
        for(i=startY; i<=endY; i++)  // 输出右边的列
            cout << arr[i][endX] << " ";
        endX --;           // 列的结束坐标减小
        for(i=endX; i>=startX; i--)   // 输出下边边的行
            cout << arr[endY][i] << " ";
        endY --;           // 行的结束坐标减小
        for(i=endY; i>=startY; i--)  // 输出左边的列
            cout << arr[i][startX] << " ";
        startX ++;         // 列的开始坐标增加
    }
}