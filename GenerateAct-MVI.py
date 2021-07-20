import os
import glob


class GenerateActMVI():

    def __init__(self):
        self.generateFileFragment()
        pass

    def generateFileFragment(self):
        # package com.ailab.aicardiotrainer.default_act_mvi.fragment
        # package com.ailab.aicardiotrainer.default_act_mvi

        folder_path = os.path.dirname(os.path.abspath(__file__))
        print("folder_path: {}".format(folder_path))

        default = {
            "package": "default_act_mvi",
            "fragment": "fragment_00",
            "package_name": "Default"
            "fragment_name" "PlayBack"
        }

        replaceValue = {
            "com.ailab.aicardiotrainer": "com.uetailab.aipacs",
            "default_act_mvi": "home_pacs", # new package name
            "Default": "HomePacs",
            "default": "homePacs",
            "fragment_00": "fragment_server",
            "PlayBack": "ServerView",
            "playBack": "serverView",
        }

        files = glob.glob(os.path.join(folder_path, "default_act_mvi", "**"), recursive=True)

        for idx, file in enumerate(files):
            # print(idx, file)
            if not os.path.isfile(file):
                continue
            if "/fragment_00" in file:
                # file for fragment
                # print("\t Fragment: {}".format(file))
                newFileAct = file.replace("default_act_mvi", replaceValue["default_act_mvi"])
                newFileAct = newFileAct.replace("fragment_00", replaceValue["fragment_00"])
                newFileAct = newFileAct.replace("PlayBack", replaceValue["PlayBack"])
                # print("New file Fragment: {}".format(newFileAct))

            else:
                # file for activity
                # print("\t Activity: {}".format(file))
                newFileAct = file.replace("default_act_mvi", replaceValue["default_act_mvi"])
                newFileAct = newFileAct.replace("Default", replaceValue["Default"])

                # print("New file: {}".format(newFileAct))
            if os.path.isfile(newFileAct):
                continue
            self.copyAndReplaceFile(file, newFileAct, replaceValue)



    def copyAndReplaceFile(self, src_file, des_file, replaceValue):
       
        os.makedirs(os.path.dirname(des_file), exist_ok=True)

        with open(src_file, "r") as fr:
            data = fr.read()
            for k, v in replaceValue.items():
                data = data.replace(k, v)
            

        with open(des_file, "w") as fw:
            fw.write(data)

        print("Done write to file: {}".format(des_file))


def main():
    generateActMVI = GenerateActMVI()

if __name__ == "__main__":
    main()