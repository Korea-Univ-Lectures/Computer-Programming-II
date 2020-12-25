import glob
from PIL import Image

def CalculateSize(files):
    width = []
    height = []

    for file in files:
        image = Image.open(file)
        width.append(image.size[0])
        height.append(image.size[1])
    #print(width)
    #print(height)
    min_width = min(width)
    min_height = min(height)
    total_width_size = min_width * len(files)
    print("min_width :", min_width)
    print("min_height :", min_height)
    print("total_width_size :" ,total_width_size)

    return min_width, min_height, total_width_size

def ConvertIMG(files, min_wdt, min_hgh, out_wdt):
    f_list=[]

    for file in files:
        image = Image.open(file)
        mod_img=image.resize((min_wdt, min_hgh)) #Resize
        mod_img=mod_img.transpose(Image.FLIP_LEFT_RIGHT) #FLIP
        mod_img=mod_img.convert("L") #Convert Gray
        f_list.append(mod_img)
        #print(resized_file.size)
        #mod_img.show()
    #f_list.show()
    return f_list


def ImageMerge(f_list, min_wdt, min_hgh, out_wdt):
    #make min canvas(mode, (w,h),(bgc))
    n_img = Image.new("RGB", (out_wdt, min_hgh), (256,256,256))
    print("out_wdt : ", out_wdt)
    print(len(f_list))

    for i in range(len(f_list)):
        canvas = ((i*min_wdt), 0, (min_wdt * (i+1)), min_hgh)
        name=f_list[i]
        n_img.paste(f_list[i], canvas)

    n_img.save("C:\내 파일\Academy\컴퓨터 프로그래밍2\수업자료\2(1) (1)\filter/output/output.png", "png")


Dir_Path = "C:\내 파일\Academy\컴퓨터 프로그래밍2\수업자료\2(1) (1)\filter/input/"

files = glob.glob(Dir_Path + "*.*")

print("num of file :", len(files))


#########################################Get Min Size###########################################
min_wdt, min_hgh, out_wdt =CalculateSize(files)
#########################################Image Resize##########################################
f_list=ConvertIMG(files, min_wdt, min_hgh, out_wdt)
#########################################Image Merge###########################################
ImageMerge(f_list, min_wdt, min_hgh, out_wdt)

