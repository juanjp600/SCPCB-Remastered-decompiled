Function updatescreens%()
    Local local0.screens
    If (selectedscreen <> Null) Then
        Return $00
    EndIf
    If (selecteddoor <> Null) Then
        Return $00
    EndIf
    For local0 = Each screens
        If (local0\Field3 = playerroom) Then
            If (1.2 > entitydistance(collider, local0\Field0)) Then
                entitypick(camera, 1.2)
                If (((pickedentity() = local0\Field0) And (local0\Field1 <> "")) <> 0) Then
                    drawhandicon = $01
                    If (mouseup1 <> 0) Then
                        selectedscreen = local0
                        local0\Field2 = loadimage_strict(scpmodding_processfilepath(("GFX\screens\" + local0\Field1)))
                        local0\Field2 = resizeimage2(local0\Field2, (Int ((Float imagewidth(local0\Field2)) * menuscale)), (Int ((Float imageheight(local0\Field2)) * menuscale)))
                        maskimage(local0\Field2, $FF, $00, $FF)
                        playsound_strict(buttonsfx)
                        mouseup1 = $00
                    EndIf
                EndIf
            EndIf
        EndIf
    Next
    Return $00
End Function
